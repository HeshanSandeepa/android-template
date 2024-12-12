package com.example.jetnews.di


import com.example.jetnews.data.interests.InterestsRepository
import com.example.jetnews.data.interests.impl.FakeInterestsRepository
import com.example.jetnews.data.posts.PostsRepository
import com.example.jetnews.data.posts.impl.BlockingFakePostsRepository
import com.example.jetnews.data.posts.impl.FakePostsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton


//// Tells Dagger this is a Dagger module
//@Module
//abstract class RepoModule {
//    @Binds
//    abstract fun providePostsRepository(postsRepository: FakePostsRepository): PostsRepository
//
//    @Binds
//    abstract fun provideInterestsRepository(interestsRepository: FakeInterestsRepository): InterestsRepository
//}



//@Qualifier
//annotation class BlockingPostRepository
//
//@Qualifier
//annotation class FakePostRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class PostFakeModule {

   // @FakePostRepository
    @Singleton
    @Binds
    abstract fun bindFakePostsRepository(impl: FakePostsRepository): PostsRepository
}

@Module
@InstallIn(SingletonComponent::class)
abstract class PosBlockingModule {

  //  @BlockingPostRepository
    @Singleton
    @Binds
    abstract fun bindBlockingFakePostsRepository(impl: BlockingFakePostsRepository): PostsRepository
}

@Module
@InstallIn(SingletonComponent::class)
abstract class InterestFakeModule {

    @Singleton
    @Binds
    abstract fun bindFakeInterestsRepository(impl: FakeInterestsRepository): InterestsRepository
}