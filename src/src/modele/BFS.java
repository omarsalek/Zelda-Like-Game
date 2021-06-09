package src.modele;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import com.sun.corba.se.impl.orbutil.graph.Graph;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class BFS {
	
	 private int V;
	  private LinkedList<Integer> adj[];
	  private Environnement env ;
	

	  // Create a graph
	  public BFS(Environnement env, int v) {
	    V = v;// v en valeur
	    this.env=env ;
	    adj = new LinkedList[v];
	    for (int i = 0; i < v; ++i)
	      adj[i] = new LinkedList();
	  }

	  // Add edges to the graph
	  public void addEdge(int v, int w) {
	    adj[v].add(w);
	  }

	  // BFS algorithm
	  public void BFS(int s) {

	    boolean visited[] = new boolean[V];

	    LinkedList<Integer> queue = new LinkedList();

	    visited[s] = true;
	    queue.add(s);

	    while (queue.size() != 0) {
	      s = queue.poll();
	      System.out.print(s + " ");

	      Iterator<Integer> i = adj[s].listIterator();
	      while (i.hasNext()) {
	        int n = i.next();
	        if (!visited[n]) {
	          visited[n] = true;
	          queue.add(n);
	        }
	      }
	    }
	  }

	@Override
	public String toString() {
		return "BFS [V=" + V + ", adj=" + Arrays.toString(adj) + ", env=" + env + "]";
	}

	
	}