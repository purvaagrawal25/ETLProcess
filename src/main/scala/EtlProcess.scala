import scala.io.Source
import java.io._

import scala.io.Source._
object EtlProcess {
  def main(args: Array[String]) {
    //part 1 of assignment
    println("Following is the content read from input file:")
    val infile = fromFile("C:\\Users\\POORVA\\IdeaProjects\\ETLProcess\\src\\main\\scala\\File1.txt")
    val pw = new PrintWriter("C:\\Users\\POORVA\\IdeaProjects\\ETLProcess\\File1.txt")
    for (line <- infile.getLines) {
      println(line)
     pw.write(line.toUpperCase+"\n")
    }
    pw.close()
    println("Following is the content read from output file:")
    val fSource = fromFile("C:\\Users\\POORVA\\IdeaProjects\\ETLProcess\\File1.txt")
    for(line<-fSource.getLines) {
      println(line)
    }
    fSource.close()
    //part 2 of Assignment
    val counter = fromFile("C:\\Users\\POORVA\\IdeaProjects\\ETLProcess\\File1.txt")
        .getLines
        .flatMap(_.split("""\W+"""))
        .foldLeft(Map.empty[String, Int]){
          (count, word) => count + (word -> (count.getOrElse(word, 0) + 1))
        }
      for ((k,v) <- counter) printf("%s : %d\n", k, v)
    val pw2 = new PrintWriter("C:\\Users\\POORVA\\IdeaProjects\\ETLProcess\\File2.txt")
      pw2.write(counter+"\n")
    pw2.close()
infile.close()
  }
}
