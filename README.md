
In-Memory Relational Data Store
This project implements an in-memory relational data store with the following features:

Create table
Delete table
Insert row
Update row
Delete row
Create index on a single column
Getting Started
To use this in-memory relational data store, follow the instructions below:

Clone this repository to your local machine:


git clone https://github.com/arpitkaushik18/InMemoryDB.git
Navigate to the project directory:


cd in-memory-relational-data-store
Run the application:


Features
Create Table
Create a table with a specified name and column list. All fields are assumed to be of type string.


# Create a table
createTable("users", ["id", "name", "email"])

# Insert a row
row_id = insertRow("users", ["1", "John Doe", "john@example.com"])

# Update a row
updateRow("users", {"name": "John Smith"})

# Delete a row
deleteRow("users", {"id": "1"})

# Create an index
createIndex("users", "email")



Feel free to contribute to this project by submitting pull requests or reporting issues. Happy coding!
