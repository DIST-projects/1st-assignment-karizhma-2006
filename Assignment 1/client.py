# Import XML-RPC client module
import xmlrpc.client

# Connect to the RPC server using EC2 public IP and port 8000
server = xmlrpc.client.ServerProxy(
    "http://<3.16.146.5>:8000/",
    allow_none=True
)

# Text sent to the server for analysis
text = "Cloud computing enables scalable and distributed computing systems"

# Invoke the remote procedure
result = server.analyze_text(text)

# Display results exactly as required
print("Text Analysis Result:")
print("Word Count:", result["word_count"])
print("Character Count:", result["character_count"])
print("Most Frequent Word:", result["most_frequent_word"])
