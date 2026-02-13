package ru.netology

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.Int
import kotlin.collections.plus

class WallServiceTest {

    @BeforeEach
    fun clearBeforeTest() {
        WallService().clear()
    }

    @Test
    fun createComment() {
        val post = Post(
            id = 1,
            date = 25,
            fromId = 35,
            text = "text text"
        )

        val comment = Comment(
            id = 1,
            commentId = 2,
            fromId = 90,
            date = 4,
            text = "new comment",
        )

        WallService().add(post)
        val newComment = WallService().createComment(1, comment)
        assertEquals(1, newComment.commentId)
    }

}


























