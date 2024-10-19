import heapq

graph = {
    'start': {'a': 6, 'b': 2},
    'a': {'fin': 1},
    'b': {'a': 3, 'fin': 5},
    'fin': {}
}

infinity = float('inf')
costs = {'a': 6, 'b': 2, 'fin': infinity}
parents = {'a': 'start', 'b': 'start', 'fin': None}

processed = set()

# Priority queue to get the lowest cost node more efficiently
priority_queue = [(cost, node) for node, cost in costs.items()]
heapq.heapify(priority_queue)  # Initialize the heap

while priority_queue:
    current_cost, node = heapq.heappop(priority_queue)
    if node in processed:
        continue
    neighbors = graph[node]
    for neighbor in neighbors:
        new_cost = current_cost + neighbors[neighbor]
        if new_cost < costs[neighbor]:
            costs[neighbor] = new_cost
            parents[neighbor] = node
            # Update the queue with new cost
            heapq.heappush(priority_queue, (new_cost, neighbor))
    processed.add(node)

print(costs)
print(parents)


# Finding the lowest-cost node takes O(log V) time using the priority queue.
# Updating the neighbors still takes O(E).
# Total time complexity: O((V + E) log V), which is much more efficient, especially when the graph has many nodes and edges.

# The priority queue adds extra space, but it is proportional to O(V) because the number of elements in the queue is at most the number of nodes.
# Total space complexity: O(V + E)
