//only extracts tags and attributes not create a tree in this part
class Solution {
    fun main(html: String) {
        val tags = extractTags(html)
        printAttributes(tags)
    }
    private fun extractTags(html: String): List<String> {
        val regex = "<[^>]+>".toRegex()
        return regex.findAll(html).map { it.value }.toList()
    }
    private fun printAttributes(tags: List<String>) {
        for (tag in tags) {
            val regex = "(\\S+)=\"(.*?)\"".toRegex()
            val matchResults = regex.findAll(tag)
            for (matchResult in matchResults) {
                val key = matchResult.groupValues[1]
                val value = matchResult.groupValues[2]
                println("$key = $value")
            }
        }
    }
}
