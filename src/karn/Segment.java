package karn;
import java.util.*;

public class Segment {
	
	private int[]tab;
    private boolean[]seg;
    boolean[]ver;
	private static Scanner sc;
    
    public Segment(int value)
    {
        tab=new int[4]; 
        ver = new boolean [4];
        if(value==0)
        {
            for(int i=0;i<4;i++)
            {
                this.tab[i]=0;
            }
           
        }
        if(value>0 && value<16) 
        {
            int i=0;
                while (value != 0)
                {
                    this.tab[i]= ( value % 2 == 0 ? 0 : 1 );
                    value /= 2;                    
                    i++;
                }                   
        } 
        for(int i=0;i<4;i++)
        {
            if(this.tab[i]==1)
            {
                this.ver[i]=true;
            }
            else 
            {
                this.ver[i]=false;
            }
        }
        
        this.Karnaugh(this.ver[3], this.ver[2], this.ver[1], this.ver[0]);
        
    }
    
    public void Karnaugh (boolean x3,boolean x2,boolean x1,boolean x0)
    {
        seg = new boolean [7];
        this.seg[0] = ((x1 && !x3) || (!x0 && !x2) || (x1 && x2) || (x0 && x2 && !x3) || (!x1 && !x2 && x3));
        this.seg[1] = ((!x2 && !x3) || (!x2 && !x0) || (x0 && !x1 && x3) || (x0 && !x3 && x1) || (!x0 && !x1 && !x3));
        this.seg[2] = ((x2 && !x3) || (!x2 && x3) || (!x1 && !x3) || (x0 && !x3) || (x0 && !x1));
        this.seg[3] = ((!x1 && x3) || (x1 && !x2 && !x3) || 
                      (!x0 && x1 && x2) || (!x0 && !x2 && !x3) || (x0 && !x2 && x3) && (x0 && !x1 && x2));
        this.seg[4] = ((x2 && x3) || (!x0 && !x2) || (x1 && x3) || (!x0 && x1));
        this.seg[5] = ((!x2 && x3) || (x1 && x3) || (!x1 && x2 && !x3) || (!x0 && x2 && !x3) || (!x0 && !x1 && !x3));
        this.seg[6] = ( (x1 && !x2) || (!x1 && x2) || x3 || (!x0 && x2)); // a refaire
        
    }
    
    public void Afficher()
    {
        System.out.println(String.format(" %s", this.seg[0]?"--":""));
        System.out.println(String.format("%s  %s", this.seg[5]?"|":" ", this.seg[1]?"|":" "));
        System.out.println(String.format(" %s", this.seg[6]?"--":""));
        System.out.println(String.format("%s  %s", this.seg[4]?"|":" ", this.seg[2]?"|":" "));
        System.out.println(String.format(" %s", this.seg[3]?"--":""));
    }
    public static void main(String[] args)
    {
		sc = new Scanner(System.in); 
    	System.out.print("Entrer un nombre entre 0 et 15 ");
    	int nb= sc.nextInt();
    	Segment test = new Segment(nb);     
        test.Afficher();
	}


}
