package ru.netology

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class WallServiceTest {
    val service = WallService()

    @Before
    fun clearBeforeTest() {
        service.clear()
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
            commentId = 5,
            fromId = 90,
            date = 4,
            text = "new comment"
        )

        service.add(post)
        val newComment = service.createComment(1, comment)
        assertEquals(1, newComment.commentId)
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
        service.add(post)
        val newComment = service.createComment(33, comment)
    }

    @Test
    fun reportComment() {
        val post = Post(
            id = 1,
            date = 25,
            fromId = 35,
            text = "text text"
        )

        val comment = Comment(
            id = 1,
            commentId = 5,
            fromId = 90,
            date = 4,
            text = "new comment"
        )

        val report = Report(
            ownerId = 1,
            commentId = 1,
            reason = 4,
        )

        service.add(post)
        val newComment = service.createComment(1, comment)
        val newReport = service.reportComment(report, newComment)
        assertEquals(1, newReport)
    }

    @Test
    fun reportComment1() {
        val post = Post(
            id = 1,
            date = 25,
            fromId = 35,
            text = "text text"
        )

        val comment = Comment(
            id = 1,
            commentId = 5,
            fromId = 90,
            date = 4,
            text = "new comment"
        )

        val report = Report(
            ownerId = 1,
            commentId = 1,
            reason = 10,
        )

        service.add(post)
        val newComment = service.createComment(1, comment)
        val newReport = service.reportComment(report, newComment)
        assertEquals(1, newReport)
    }
}