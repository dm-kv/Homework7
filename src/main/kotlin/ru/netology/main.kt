package ru.netology

data class Comment (
    var id: Int,
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

    fun findById(postId: Int) : Post? {
        for ((index, post) in posts.withIndex()) {
            if (postId == post.id) {
                return posts[postId]
            }
        }
        return null
    }

    fun createComment(postId: Int, comment: Comment): Comment {
        val service = WallService()
        comments[postId] = service.findById(postId)? : throw PostNotFoundException ("No posts with this id $postId")
        return comment
    }
}

