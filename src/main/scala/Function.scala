object Function extends App {
  // 関数
  def test (a: String, b: Int): String = {
    a + b
  }
  println(test("a", 1))

  // 関数で中括弧を省略
  def test2(a: String, b: Int): String = a + b
  println(test2("a", 1))

  // 関数で中括弧と戻り型を省略
  def test3(a: String, b: Int) = println(a + b)
  test3("a", 1)

  ///////////////////

  // 関数リテラル
  (a: String, b: Int) => {
    a + b
  }: String

  // 関数リテラルで中括弧を省略
  (a: String, b: Int) => a + b: String

  // 関数リテラルで中括弧と戻り型を省略
  (a: String, b: Int) => a + b

  // 少しずつ省略していく
  Array("a", "b", "c").map((x: String) => {
    println(x)
  })
  Array("a", "b", "c").map((x: String) => println(x))
  Array("a", "b", "c").map((x) => println(x))
  Array("a", "b", "c").map(x => println(x))
  Array("a", "b", "c").map(println)

  ///////////////////

  // valを利用
  val test4: (String, Int) => String =
    (aaa: String, bbb: Int) => {
      aaa + bbb
    }: String
  println(test4("aaa", 1))

  // valを利用(省略)
  val test5: (String, Int) => String = (aaa: String, bbb: Int) => aaa + bbb
  println(test5("aaa", 1))

  ///////////////////

  // PartialFunction(部分関数)
  val convertNumberIntoKanji = new PartialFunction[Int, String] {
    val chineseNumeral = Array("零", "一", "二", "三", "四", "五", "六", "七", "八")
    def apply(i: Int) = chineseNumeral(i)
    def isDefinedAt(i: Int) = i >= 0 && i <= 8
  }

  if (convertNumberIntoKanji.isDefinedAt( 7 )) {
    println("7の漢字表記 = " + convertNumberIntoKanji(7))
  }

  println("引数：-1 = " + convertNumberIntoKanji.isDefinedAt(-1))

  ///////////////////

  val abc = (greeting: String) => (name: String) => {
    greeting + "！ " + name + "！"
  }

  val a = abc("hello")
  println(a("jiro"))

  println(abc("hello")("taro"))

  ///////////////////

  // 引数の関数渡し
  def withFunctionAsArgument(aFunction: => String => String): String = {
    aFunction("こんにちは")
  }

  val displayGreeting = (greeting: String) => {
    greeting + "!!"
  }

  println(withFunctionAsArgument(displayGreeting))
}
