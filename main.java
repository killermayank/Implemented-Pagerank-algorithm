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
