package felina;

public class Graph {
	private int vertices;
	int[][] graphMatrix;
	final int s = 5;

	public Graph(int vertices) {
		if (vertices != s) {
			System.out.println("Wrong amount of V");
		}
		this.vertices = vertices;
		graphMatrix = new int[vertices][vertices];
	}

	public void addWeightedEdge(int begin, int end, int weight) {
		graphMatrix[begin][end] = weight;
		graphMatrix[end][begin] = weight;
	}

	int FMD(int[] dist, Boolean[] shortPath) {
		int min = Integer.MAX_VALUE;
		int minV = -1;
		for (int i = 0; i < s; i++) {
			if (!shortPath[i] && dist[i] <= min) {
				min = dist[i];
				minV = i;
			}
		}
		return minV;
	}

	void printResult(int[] distances, int[] parent, int source) {
		for (int i = 0; i < s; i++) {
			System.out.print(i + "\t\t");
			if (distances[i] == Integer.MAX_VALUE) {
				System.out.print("There is no path");
			} else {
				System.out.print(distances[i] + "\t\t");
				printPath(i, parent);
				System.out.println();
			}
		}
	}

	void printPath(int temp, int[] parent) {
		if (temp == -1) {
			return;
		}

		printPath(parent[temp], parent);
		System.out.print(temp);
		if (temp != parent.length) {
			System.out.print(" to ");
		}
	}

	public void djikstra(int source, int[][] graphMatrix) {
		int[] dist = new int[s];
		Boolean[] shortPath = new Boolean[s];
		int[] parent = new int[s];

		for (int i = 0; i < s; i++) {
			dist[i] = Integer.MAX_VALUE;
			shortPath[i] = false;
			parent[i] = -1;
		}

		dist[source] = 0;

		for (int i = 0; i < s - 1; i++) {
			int u = FMD(dist, shortPath);
			if (u == -1)
				break;

			shortPath[u] = true;

			for (int v = 0; v < s; v++) {
				if (!shortPath[v] && graphMatrix[u][v] != 0 && dist[u] != Integer.MAX_VALUE
						&& dist[u] + graphMatrix[u][v] < dist[v]) {
					dist[v] = dist[u] + graphMatrix[u][v];
					parent[v] = u;
				}
			}
		}

		printResult(dist, parent, source);
	}

	public void printGraph() {
		System.out.println("Graph edges with weights:");
		for (int i = 0; i < s; i++) {
			for (int j = i + 1; j < s; j++) {
				if (graphMatrix[i][j] != 0) {
					System.out.println("Vertex " + i + " Vertex " + j + " : " + graphMatrix[i][j] + " units");
				}
			}

		}
	}

	public void Starttofinish(int Start, int Finish, int[][] GraphMatrix, String[] buildingNames) {

	    int[] dist = new int[s];
	    Boolean[] shortPath = new Boolean[s];
	    int[] parent = new int[s];

	    for (int i = 0; i < s; i++) {
	        dist[i] = Integer.MAX_VALUE;
	        shortPath[i] = false;
	        parent[i] = -1;
	    }

	    dist[Start] = 0;

	    for (int i = 0; i < s - 1; i++) {
	        int u = FMD(dist, shortPath);
	        if (u == -1)
	            break;

	        shortPath[u] = true;

	        for (int v = 0; v < s; v++) {
	            if (!shortPath[v] && GraphMatrix[u][v] != 0 && dist[u] != Integer.MAX_VALUE
	                    && dist[u] + GraphMatrix[u][v] < dist[v]) {
	                dist[v] = dist[u] + GraphMatrix[u][v];
	                parent[v] = u;
	            }
	        }
	    }

	    System.out.println("Shortest path from " + buildingNames[Start] + " to " + buildingNames[Finish]);

	    if (dist[Finish] == Integer.MAX_VALUE) {
	        System.out.println("Path does not exist.");
	    } else {
	        System.out.println("Path: ");
	        printPathWithNames(Finish, parent, buildingNames);
	        System.out.println("Total Distance: " + dist[Finish] + " units");
	    }
	}

	void printPathWithNames(int current, int[] parent, String[] buildingNames) {
	    if (current == -1) {
	        return;
	    }

	    printPathWithNames(parent[current], parent, buildingNames);
	    System.out.print(buildingNames[current]);
	    if (current != parent.length) {
	        System.out.print(" -> ");
	    }
	}


}
