package com.ykis.ykismob.di

import android.content.Context
import androidx.room.Room
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.ykis.ykismob.data.cashe.appartment.AppartmentCache
import com.ykis.ykismob.data.cashe.user.UserCache
import com.ykis.ykismob.data.dao.AppDatabase
import com.ykis.ykismob.data.dao.AppartmentDao
import com.ykis.ykismob.data.dao.FamilyDao
import com.ykis.ykismob.data.remote.address.AddressRemote
import com.ykis.ykismob.data.remote.appartment.AppartmentRemote
import com.ykis.ykismob.data.remote.service.ApiService
import com.ykis.ykismob.data.remote.service.ApiService.Companion.BASE_URL
import com.ykis.ykismob.domain.address.AddressRepository
import com.ykis.ykismob.domain.address.AddressRepositoryImpl
import com.ykis.ykismob.domain.appartment.AppartmentRepository
import com.ykis.ykismob.domain.appartment.AppartmentRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Singleton
    @Provides
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor()
        .apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Singleton
    @Provides
    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

    @Singleton
    @Provides
    fun provideRetrofit(moshi: Moshi, okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)


    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }



    @Provides
    fun provideAppartmentDao(db: AppDatabase): AppartmentDao {
        return db.appartmentDao()
    }

    @Provides
    fun provideFamilyDao(db: AppDatabase): FamilyDao {
        return db.familyDao()
    }

    @Singleton
    @Provides
    fun provideAppartmentRepository(
        appartmentRemote: AppartmentRemote,
        userCache: UserCache,
        appartmentCache: AppartmentCache
    ): AppartmentRepository {
        return AppartmentRepositoryImpl(appartmentRemote,appartmentCache,userCache)
    }

    @Singleton
    @Provides
    fun provideAddressRepository(
        addressRemote: AddressRemote,
        userCache: UserCache,
    ): AddressRepository {
        return AddressRepositoryImpl(addressRemote,userCache)
    }

}