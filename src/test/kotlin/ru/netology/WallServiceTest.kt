package ru.netology

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.Int


class WallServiceTest {
    @Test
    fun createComment() {
        val post = Post(
            id = 17,
            date = 25,
            fromId = 35,
            text = "text text"
        )

        val comment = Comment(
            id = 137,
            commentId = 17,
            fromId = 90,
            date = 4,
            text = "new comment",
        )

        val newComment = WallService.createComment(17, comment)
        assertEquals(17, newComment.commentId)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        val post = Post(
            id = 17,
            date = 25,
            fromId = 35,
            text = "text text"
        )

        val comment = Comment(
            id = 137,
            commentId = 23,
            fromId = 90,
            date = 4,
            text = "new comment",
        )
        WallService.createComment(33, comment)
    }
}

















