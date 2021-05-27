package fixtures;

public abstract class Fixture {
   public String name;
   public String shortDescription;

   public Fixture(String name, String shortDescription)
   {
      this.name = name;
      this.shortDescription = shortDescription;
   }
   
   public abstract void describe();
}
