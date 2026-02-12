package ru.netology
import ru.netology.WallService

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

class PostNotFoundException(message: String) : RuntimeException(message)

class WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
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

    fun createComment(postId: Int, comment: Comment): Comment {
        val service = WallService()
        if (service.findById(postId)) {
            comment.commentId = postId
            comments += comment
            return comment
        } else throw PostNotFoundException ("No posts with this id $postId")
    }
}

