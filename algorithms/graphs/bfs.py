from collections import deque

graph = {
    'you': ['alice', 'bob', 'claire'],
    'bob': ['anuj', 'peggy'],
    'alice': ['peggy'],
    'claire': ['thom', 'jonny'],
    'anuj': [],
    'peggy': [],
    'thom': [],
    'jonny': []
}


def person_is_seller(name):
    return name[-1] == 'm'


def search(name):
    search_queue = deque(graph[name])  # Initialize the queue with neighbors
    searched = set()  # Using a set for faster lookups
    while search_queue:
        person = search_queue.popleft()
        if person not in searched:
            if person_is_seller(person):
                print(person + ' is a mango seller!')
                return True
            search_queue += graph[person]
            searched.add(person)
    return False


search('you')


# Time Complexity:
# The time complexity of BFS in this case is O(V + E), where:
# 𝑉
# V is the number of vertices (nodes, or people in this case).

# 𝐸
# E is the number of edges (connections between people).

# Explanation:

# Each node is dequeued and processed exactly once.
# For each node, we look at its adjacent nodes (its neighbors), and that is done once per edge.
# Thus, the total time complexity is proportional to the sum of the vertices and the edges in the graph, i.e., O(V + E).

# Space Complexity:
# The space complexity is also O(V + E) because:
# We store all vertices and edges in the graph.
# The BFS queue can hold at most all vertices in the worst case.
# The searched set can also hold up to
# 𝑉
# V people.
# Thus, both the queue and the searched set will take O(V) space, and storing the graph requires O(V + E). Therefore, the overall space complexity is O(V + E).
