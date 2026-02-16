package ru.netology

data class Comment (
    var id: Int,
    var commentId: Int,
    val fromId: Int,
    val date: Int,
    val text: String,
)

data class Post(
    var id: Int,
    val date: Int,
    val fromId: Int,
    val text: String,
)

data class Report(
    val ownerId: Int,
    val commentId: Int,
    var reason: Int,
)

class PostNotFoundException(message: String) : RuntimeException(message)
class ReasonNotFoundException(message: String) : RuntimeException(message)

class WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
    private var reports = emptyArray<Report>()
    private var prId: Int = 1

    fun clear() {
        posts = emptyArray()
        prId = 1
    }

    fun add(post: Post): Post {
        posts += post.copy(id = prId++)
        return posts.last()
    }

    fun findById(postId: Int) : Boolean {
        for ((index, post) in posts.withIndex()) {
            if (postId == post.id) {
                return true
            }
        }
        return false
    }

    fun checkTheReason(reason: Int) = when (reason) {
        in 0..6 -> true
        8 -> true
        else -> false
    }

    fun createComment(postId: Int, comment: Comment): Comment {
        if (findById(postId)) {
            comment.commentId = postId
            comments += comment
            return comment
        } else throw PostNotFoundException ("No posts with this id $postId")
    }

    fun reportComment(report: Report, comment: Comment): Int {
        if (report.commentId == comment.commentId) {
            if (checkTheReason(report.reason)) {
                reports += report
                return 1
            } else throw ReasonNotFoundException ("This reason does not exist")
        } else throw PostNotFoundException ("No posts with this id")
    }
}

