package fp.think

class ComplexTest  {
  
  def fixture = 
    new {
      val a = new Complex(1, 2)
      val b = new Complex(30, 40)
    };
  
    val f = fixture
    val z = f.a + f.b
    assert(1 + 30 == z.real)
  
    assert(f.a < f.b)
    assert(new Complex(1,2) >= new Complex(3,4))
  
}