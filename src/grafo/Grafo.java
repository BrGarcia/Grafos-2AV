package grafo;

import java.util.ArrayList;

public class Grafo {
    protected ArrayList<Vertice> listaVertices = new ArrayList<Vertice>();
    protected ArrayList<Aresta> listaArestas = new ArrayList<Aresta>();
    protected Vertice tVertice1,tVerticeOutIn,tVerticeOut, tVertice;
    protected Aresta tAresta, tAresta1;
    
    private int cont1 = 0;
    private int cont2 = 0;
    private int adj[][];
    private int acss[][];
    protected int ordenado;
    private int algDJ;
    private int algBF;
    private int algFW;
    
    public int getAlgDJ(){
    	return algDJ;
    }
    
    public int getAlgBF(){
    	return algBF;
    }
    
    public int getAlgFW(){
    	return algFW;
    }
    
    public boolean ehOrdenado (){
    	if (ordenado == 1){
    		return true;
    	}
    	return false;
    }
        
    public void criarVertice(){
    tVertice1 = new Vertice();
	cont1 = cont1+1;
	tVertice1.setId(cont1);
	listaVertices.add(tVertice1);
    }
    
	public void criarAresta(int verticeOrigem, int verticeDestino, int peso){
		tAresta = new Aresta();
		cont2 = cont2+1;
		tAresta.setVerticeOrigem(verticeOrigem);
		tAresta.setVerticeDestino(verticeDestino);
		tAresta.setId(cont2);
		tAresta.setPeso(peso);
		listaArestas.add(tAresta);
		tVerticeOut = listaVertices.get(verticeOrigem-1);
		tVerticeOut.setGrau(tVerticeOut.getGrau()+peso);
		tVerticeOutIn = listaVertices.get(verticeDestino-1);
		tVerticeOutIn.setGrau(tVerticeOutIn.getGrau());
		if(ehOrdenado()== false){
			tVerticeOutIn = listaVertices.get(verticeDestino-1);
			tVerticeOutIn.setGrau(tVerticeOutIn.getGrau()+peso);
		}
    }

    public int getContV() {
		return cont1;
	}

	public int getContA() {
		return cont2;
	}
    
    public boolean testaVertice(int vertId){
    	if(listaVertices.isEmpty() == false)
    		return true;
    	else
    		return false;
    }
    
    public boolean testaAresta(int arestaId){
    	if(listaArestas.isEmpty() == false)
    		return true;
    	else
    		return false;
    }
    
    public boolean deletarVertice(int vertId, int vertOrigem, int vertDestino){
    	if(testaVertice(vertId) == true){
    			if(testaAresta(0)== true){
    				tAresta1 = listaArestas.get(vertOrigem);
    				do{
    					if(tAresta1.getVerticeDestino() == vertId+1){
    						tVerticeOutIn =  listaVertices.get(tAresta1.getVerticeDestino()-1);
    						tVerticeOutIn.setGrau(tVerticeOutIn.getGrau()-tAresta1.getPeso());
    						listaArestas.remove(tAresta1);
    					}
    					else{
    						vertOrigem = vertOrigem + 1;
    						tAresta1 = listaArestas.get(vertOrigem);
    					}
				
    				}while (tAresta1.getVerticeDestino() != vertId+1);
    				if(tAresta1.getVerticeDestino() == vertId+1){
    					tVerticeOutIn = listaVertices.get(tAresta1.getVerticeDestino()-1);
    					tVerticeOutIn.setGrau(tVerticeOutIn.getGrau()-tAresta1.getPeso());
    					listaArestas.remove(tAresta1);
    				}
    				vertId = vertDestino;
    				vertOrigem = 0;
    				tAresta1 = listaArestas.get(vertOrigem);
    				do{
    					if(tAresta1.getVerticeOrigem() == vertId+1){
    						tVerticeOut = listaVertices.get(tAresta1.getVerticeOrigem()-1);
    						tVerticeOut.setGrau(tVerticeOut.getGrau()-tAresta1.getPeso());
    						listaArestas.remove(tAresta1);
    					}
    					else{
    						vertOrigem = vertOrigem + 1;
    						tAresta1 = listaArestas.get(vertOrigem);
    					}
    				}while (tAresta1.getVerticeOrigem() != vertId+1);
    				if(tAresta1.getVerticeOrigem() == vertId+1){
    					tVerticeOut = listaVertices.get(tAresta1.getVerticeOrigem()-1);
    					tVerticeOut.setGrau(tVerticeOut.getGrau()-tAresta1.getPeso());
    					listaArestas.remove(tAresta1);
    				}
    			}
    		tVertice = listaVertices.get(vertId);
			listaVertices.remove(tVertice);
			cont1--;
			return true;
    	}
    	else
    		return false;
    }
    
    public boolean deletarAresta(int arestaId){
    	if(testaAresta(arestaId)==true){
    		tAresta1 = listaArestas.get(arestaId);
    		tVerticeOut = listaVertices.get(tAresta1.getVerticeOrigem()-1);
    		tVerticeOut.setGrau(tVerticeOut.getGrau()-tAresta1.getPeso());
    		tVerticeOutIn = listaVertices.get(tAresta1.getVerticeDestino()-1);
    		tVerticeOutIn.setGrau(tVerticeOutIn.getGrau());
			if(ehOrdenado()== false){
				tVerticeOutIn = listaVertices.get(tAresta1.getVerticeDestino()-1);
				tVerticeOutIn.setGrau(tVerticeOutIn.getGrau()-tAresta1.getPeso());
			}
			listaArestas.remove(tAresta1);
    		cont2--;
    		return true;
    	}
    	else
    		return false;
    }
    
    public int grauMax(){
    	int i,aux = 0;
    	for(i=0; i< listaVertices.size(); i++){
    		tVertice = listaVertices.get(i);
    		if(tVertice.getGrau() > aux)
    			aux = tVertice.getGrau();
    	}
    	return aux;
    }
    
   public int grauMinimo(){
	   int i,aux=0;
	   for(i=0; i< listaVertices.size(); i++){
		   tVertice = listaVertices.get(i);
   			if(i == 0)
   				aux = tVertice.getGrau();
   			if(tVertice.getGrau() < aux)
   				aux = tVertice.getGrau();
   		}
   		return aux;
    }
   
   public int grauMedio(){
	   int i,aux;
	   aux = 0;
	   for(i=0; i< listaVertices.size(); i++){
		   tVertice = listaVertices.get(i);
		   aux = aux + tVertice.getGrau();
	   }
	   aux = aux / listaVertices.size();
	   return aux;
   }
   
   private int[][] zeraMatrizAdj(){
	   int i,j,aux;
	   aux = listaVertices.size();
	   adj = new int [aux][aux];
	   for(i = 0; i < aux; i++){
		   for(j = 0; j < listaVertices.size(); j++){
			   adj[i][j] = 0;
		   }
	   }
	   return adj;
   }
  
   public int [][] geraMatrizAdj(){
	   int i,j;
	   adj = zeraMatrizAdj();
	    System.out.println();
	    if(listaArestas.isEmpty() == false){
	    	for(i = 0; i < listaVertices.size(); i++){
	    		for(j = 0; j < listaArestas.size(); j++){
	    			tAresta1 = listaArestas.get(j);
	    			if(tAresta1.getVerticeOrigem()-1 == i){
	    				adj[i][tAresta1.getVerticeDestino()-1] = adj[i][tAresta1.getVerticeDestino()-1] + tAresta1.getPeso();
	    				if(ehOrdenado()==false)
	    					adj[tAresta1.getVerticeDestino()-1][i] = adj[tAresta1.getVerticeDestino()-1][i] + tAresta1.getPeso();
	    			}
	    		}
	    	}
   
	    }
	    return adj;
   }
   
   public void imprimeMatriz(int adj[][]){
	   int i,j;
    	for(i = 0; i < listaVertices.size(); i++){
    		for(j = 0; j < listaVertices.size(); j++){
    			System.out.print(adj[i][j] + " ");
    		}
    		System.out.println();
    	}
   }
   
   private void buscaEmProfundidade(int vertice, int adj[][]){  
	   int i;
	   tVertice = listaVertices.get(vertice);
	   tVertice.setPercorrido(true);
	   for(i=0; i < cont1; i++){
		   if(adj[tVertice.getId()-1][i] > 0 && listaVertices.get(i).eVisitado() == false) {
			   vertice = i;
			   tVertice = listaVertices.get(vertice);
			   buscaEmProfundidade(vertice, adj);
		   }
	   }
   }
   
   private void zeraBusca(){
	   int i;
	   for(i=0; i< cont1; i ++){
		   listaVertices.get(i).setPercorrido(false);
	   }
   }
   
   public boolean conexo(){
	   int i;
	   adj = geraMatrizAdj(); 	
		buscaEmProfundidade(0, adj);
		for(i=0; i<listaVertices.size(); i++){
			tVertice = listaVertices.get(i);
			if(tVertice.eVisitado() == false){
				zeraBusca();
				return false;
			}
		}
		zeraBusca();
    	return true;
    }

   public void imprimeVertices(){
	   int i;
	   System.out.println("Vertices:");
	   for(i=0; i<listaVertices.size(); i++){
		   tVertice = listaVertices.get(i);
		   System.out.println("Vertice: " + tVertice.getId() + " Grau: " + tVertice.getGrau());
	   }
   }
   
   public void imprimeArestas(){
	   int i;
	   if(testaAresta(0) == true){
		   System.out.println("Arestas:");
		   for(i=0; i<listaArestas.size(); i++){
			   tAresta1 = listaArestas.get(i);
			   System.out.println("Aresta " + tAresta1.getId() +": liga o vertice " + tAresta1.getVerticeOrigem() + " com o vertice " + tAresta1.getVerticeDestino());
		   }
	   }
	   else
		   System.out.println("Este grafo não tem arestas");
   }
   
   public void imprimeBellmanFord(int x){
	   int i = 0;
	   int [] vetorCaminho = bellmanFord(x);
	   for(i=0;i<cont1;i++){
		   System.out.print(vetorCaminho[i] + " ");
	   }
   }
      
   public boolean caminhoEuler(int adj[][]){
	   int total=0,grau, i=1,j;
	   if(conexo()==true){
		   while(total<=2 && i< cont1){
			   grau=0;
			   for(j=1; j<cont1; j++){
				   if(adj[i][j]>0)
					   grau = grau + adj[i][j];
			   }
			   if(grau%2 != 0){
				   total = total+1;
			   }
			   i++;
		   }
		   if(total > 2){
			   return false;
		   }
		   else
			   return true;
	   }
	   else
		   return false;
   }
   
   public int[][] warshall () {
	  int k,i,j;
	  acss = geraMatrizAdj();
	  for(i=0; i<cont1; i++){
		  for(j=0; j<cont1; j++){
			  if(acss[i][j]>0){
				  acss[i][j] = 1;
			  }
		  }
	  }
	  for (k = 0; k < cont1; k++) {
		  for (i = 0; i < cont1; i++){
			  for (j = 0; j < cont1; j++){
				  acss[i][j] |= acss[i][k] & acss[k][j];
			  }
		  }
	  }
	  return acss;
   }
   
   public int dijkstra(int x, int y){
	   x=x-1;
	   y=y-1;
	   int[][]adjp = preparaMatrizAdj();
	   ArrayList<Integer> IN = new ArrayList<Integer>();
	   int d[] = new int[adjp.length];
	   int s[] = new int[adjp.length];
	   IN.add(x);
	   d[x]=0;
	   algDJ = 0;
	   int i=0,p=0,z=0,distAnterior=0,minimo =99999;
	   for(i=0;i<d.length;i++){
		   algDJ = algDJ +1;
		   if(IN.contains(i) == false){
			   d[i]=adjp[x][i];
			   s[i]=x;
		   }
	   }
	   while(IN.contains(y) == false){
		   algDJ = algDJ +1;
		   minimo =99999;
		   for(i=0;i<adjp.length;i++){
			   if(IN.contains(i) == false){
				   if(d[i]< minimo){
					   minimo=d[i];
					   p = i;
				   }
			   }
		   }
		   IN.add(p);
		   for(i=0;i<adjp.length;i++){
			   algDJ = algDJ +1;
			   if(IN.contains(i) == false){
				   distAnterior = d[i];
				   d[i] = Math.min(d[i], d[p]+adjp[p][i]);
				   if(d[i] != distAnterior){
					   s[i] = p;
				   }
			   }
		   }
	   }
	   z=y;
	   do{
		   algDJ = algDJ +1;
		   z=s[z];
	   }while(z!=x);
	   p = d[y];
	   return p;
   } 
   
   private int[] bellmanFord(int x){
	   int i;
	   algBF = 0;
	   int[][]adjp = preparaMatrizAdj();
	   int vetorCaminho[] = new int [adjp.length];
	   for(i=0; i<adjp.length;i++){
		   algBF = algBF + 1;
		   vetorCaminho[i] = dijkstra(x, (i+1));
	   }
	   algBF = algBF + algDJ;
	   return vetorCaminho;
   }
   
   
   public int[][] floydWarshall(){
	    int[][]path = preparaMatrizAdj();
	    algFW=0;
	    for(int k=0;k<path.length;k++){	
	    	algFW = algFW+1;
	    	for(int i=0;i<path.length;i++){
	    		algFW = algFW+1;
	    		for(int j=0;j<path.length;j++){
	    			algFW = algFW+1;
	    			if(path[i][j] > (path[i][k] + path[k][j])){
	    				path[i][j] = path[i][k] + path[k][j];
	    			}
	    		}
	    	}
	    }
	    return path;
   }
   
   private int [][] preparaMatrizAdj(){
	   int adjp[][] = geraMatrizAdj();
	   int i,j;
	   for(i=0; i<adj.length; i++){
		   for(j=0; j<adj.length; j++){
			   if(i == j){
				   adjp[i][j] = 0;
			   }
			   else if(adjp[i][j] == 0){
				   adjp[i][j] = 9999;
			   }
		   }
	   }
	   return adjp;
   }
   
   public int contaTermos(){
	   int termos = 0;
	   int i;
	   int adjc[][] = geraMatrizAdj();
	   tVertice = listaVertices.get(0);
	   zeraBusca();
	   for(i=0; i<listaVertices.size(); i++){
		   tVertice = listaVertices.get(i);
		   if(tVertice.eVisitado() == false){
			   buscaEmProfundidade(0, adjc);
			   termos = termos+1;
		   }
			   
	   }
	   //termos = termos-1;
	   //if(termos == 0){
		   //termos = 1;
	   //}
	   return termos;
   }

}
