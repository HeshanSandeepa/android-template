package com.example.jetnews.di


import com.example.jetnews.data.interests.InterestsRepository
import com.example.jetnews.data.interests.impl.FakeInterestsRepository
import com.example.jetnews.data.posts.PostsRepository
import com.example.jetnews.data.posts.impl.FakePostsRepository
import dagger.Binds
import dagger.Module


// Tells Dagger this is a Dagger module
@Module
abstract class RepoModule {
    @Binds
    abstract fun providePostsRepository(postsRepository: FakePostsRepository): PostsRepository

    @Binds
    abstract fun provideInterestsRepository(interestsRepository: FakeInterestsRepository): InterestsRepository
}

