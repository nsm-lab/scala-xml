/*                     __                                               *\
**     ________ ___   / /  ___     Scala API                            **
**    / __/ __// _ | / /  / _ |    (c) 2003-2020, LAMP/EPFL             **
**  __\ \/ /__/ __ |/ /__/ __ |    (c) 2011-2020, Lightbend, Inc.       **
** /____/\___/_/ |_/____/_/ | |    http://scala-lang.org/               **
**                          |/                                          **
\*                                                                      */

package scala
package xml

/**
 * The class `Comment` implements an XML node for comments.
 *
 * @author Burak Emir
 * @param commentText the text contained in this node, may not contain "--"
 */
case class Comment(commentText: String) extends SpecialNode {

  def label = "#REM"
  override def text = ""
  final override def doCollectNamespaces = false
  final override def doTransform = false

  if (commentText contains "--")
    throw new IllegalArgumentException("text contains \"--\"")

  /**
   * Appends &quot;<!-- text -->&quot; to this string buffer.
   */
  override def buildString(sb: StringBuilder) =
    sb append "<!--" append commentText append "-->"
}
