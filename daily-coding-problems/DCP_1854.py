# Given a string and a set of characters, return the shortest substring containing all the characters in the set.

# For example, given the string "figehaeci" and the set of characters {a, e, i}, you should return "aeci".

# If there is no substring containing all the characters in the set, return null.

from collections import defaultdict

def min_window_substring(s, chars):
    if not s or not chars:
        return None

    # Convert the set of characters into a frequency dictionary
    char_count = defaultdict(int)
    for char in chars:
        char_count[char] += 1

    required = len(char_count)  # Number of unique characters we need to match
    left = 0  # Left pointer for the sliding window
    formed = 0  # To track how many unique characters in current window match with char_count
    window_counts = defaultdict(int)  # Dictionary to count characters in the current window
    min_len = float("inf")  # To track the minimum length of valid window
    min_window = ""  # To store the result

    # Sliding window expansion with the right pointer
    for right in range(len(s)):
        char = s[right]
        window_counts[char] += 1

        # Check if the current character satisfies the required frequency
        if char in char_count and window_counts[char] == char_count[char]:
            formed += 1

        # Try to contract the window until it's no longer valid
        while left <= right and formed == required:
            char = s[left]

            # Update the result if this window is smaller than previously found valid window
            if right - left + 1 < min_len:
                min_len = right - left + 1
                min_window = s[left:right + 1]

            # Contract the window from the left
            window_counts[char] -= 1
            if char in char_count and window_counts[char] < char_count[char]:
                formed -= 1

            left += 1

    # If no valid window is found, return None
    return min_window if min_len != float("inf") else None

# Example usage:
s = "figehaeci"
chars = {'a', 'e', 'i'}
result = min_window_substring(s, chars)
print(result)  # Output: "aeci"
