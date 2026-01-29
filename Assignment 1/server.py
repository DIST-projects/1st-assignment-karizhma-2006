# Import SimpleXMLRPCServer to create an RPC server
from xmlrpc.server import SimpleXMLRPCServer

# Counter is used to find the most frequent word
from collections import Counter

# string is used to remove punctuation
import string

# Remote procedure that performs text analysis
def analyze_text(text):
    # Convert text to lowercase and remove punctuation
    text = text.lower().translate(str.maketrans("", "", string.punctuation))
    
    # Split the text into words
    words = text.split()

    # Return analysis results as a dictionary
    return {
        "word_count": len(words),                 # Total number of words
        "character_count": len(text),             # Total characters (after cleaning)
        "most_frequent_word": Counter(words).most_common(1)[0][0]
    }

# Create an XML-RPC server listening on all interfaces at port 8000
server = SimpleXMLRPCServer(("0.0.0.0", 8000), allow_none=True)

# Display server startup message
print("RPC Text Analytics Server running on port 8000...")

# Register the remote function
server.register_function(analyze_text, "analyze_text")

# Keep the server running forever
server.serve_forever()
