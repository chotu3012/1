import java.util.*;
class Monster{
       public void attack(){
         System.out.println("Monster is attacking");
         
        }
   }
   
   class FireMonster extends Monster{
         @Override
         public void attack(){
           System.out.println("FireMonster is attacking");
          }
      }
      
      class WaterMonster extends Monster{
             @Override
             public void attack(){
             System.out.println("WaterMonster is attacking");
           }
        }
        
        class StoneMonster extends Monster{
           @Override
           public void attack(){
             System.out.println("StoneMonster is attacling");
          }
      }
      
    public class MonsterGame{
          public static void main(String[] args)
          {
            Monster monster1=new FireMonster();
            Monster monster2=new WaterMonster();
            Monster monster3=new StoneMonster();
            
            monster1.attack();
            monster2.attack();
            monster3.attack();
         
         }
      }
