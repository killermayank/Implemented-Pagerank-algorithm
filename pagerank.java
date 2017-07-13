/*

This is Google pagerank algorithm  
implemented in java 
  
 */
package pageranking;

import java.util.Scanner;

/**
 *
 * @author Mayank Sharma
 */
public class Pageranking 
{

    // Iniatializing the array adj as storing the 
    // adjacent martrix as connect of graph
    // 0 for not connected 
    // 1 for connected
    public int adj[][] = new int[20][20];
    // as ranking will contain the 
    // value of rank 
    // for different value 
    // as iniatialially 
    // it wil contain 
    // 1/(no of nodes) 
    public double ranking[]  = new double[20];
    
    public void solve(double n)
    {
        // initial pagerank
        double init;
        // no of outgoing nodes
        // from a particular 
        //vertex
        double degree =0;
        //as suggested by the different
        // websites the damping 
        // factor varies 
        // it is calculated as 
        // probability of no of
        // random searches
        double dampingfactor = 0.85;
        int k=1;
        int i = 1;
        
        // initial pagerank is calculated as
        // 1 divided by no of pages
        init = (1/n);
        System.out.printf(" Total Number of Nodes :"+n+"\t Initial PageRank  of All Nodes :"+init+"\n");
       
        // here we are initilizing the value 
        // with 1/n
        // as we initialized the all the value with 1/n
        // next we have to perfrom iteration
        // to calcuate the ranking 
        // so what we have to do
        //by formula
        // pg(k) = (1-d)/n *d*(p1(t)*(p2(t))........
        for(k=1;k<=n;k++)
        {
           ranking[k] = init;
        }
        
        System.out.println("\n Pagerank a 0th iteration :\n");
        //all the ranks of the pages at 0th iteration
        for(k=1;k<=n;k++)
        {
            System.out.println(" Ranking of "+k+" is :\t"+ranking[k]+"\n");
        }
        i=1;
        double temp[] = new double[20];
        while(i<=2)
        {
            for(k=1;k<=n;k++)
            {
                temp[k] = ranking[k];
                ranking[k] = 0;
            }
            
            for(int j=1 ; j<=n ; j++)
            {
                for(int l=1 ; l<=n ; l++)
                {
                    if( adj[l][j]== 1 )
                    {
                        k =1;
                        degree =0;
                        while(k<=n)
                        {
                            if(adj[l][k] == 1)
                            {
                               ++degree;
                            }
                            k++;
                        }
                        
                          ranking[j] += temp[l]*(1/degree);
                    }
                  
                }
            }
            
            System.out.println("\n After "+i+"th step : \n");
            
            for(k=1;k<=n;k++)
            {
               System.out.println("Ranking of " +k+ " is  "+ranking[k]+'\n'); 
            }
            i++;
        }
        
        // adding damping number to the pagerank
        // final solution of the pagerank
        
        for(k=1;k<=n;k++)
        {
            ranking[k]= (1-dampingfactor)+dampingfactor *ranking[k];
        }
        

        /// final solution 
        System.out.println("\n Final rank of the page  is : \n");
        for(k=1;k<=n;k++)
        {
         System.out.println("Ranking of "+k+" is "+ranking[k]+'\n'); 
        }
    }
            
    public static void main(String[] args) 
    {
        int n;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of nodes or pages :\n");
        n = in.nextInt();
        System.out.print("Enter the adjacency matrix : \n");
        // creating object for the class
        Pageranking  obj= new Pageranking();
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
               obj.adj[i][j]= in.nextInt();
               if(i==j)
               obj.adj[i][j]=0;
            }
        }
        obj.solve(n);
    }
    
 }
