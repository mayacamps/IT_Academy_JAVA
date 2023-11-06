// MONGO DB QUERIES - Restaurants collection
//1 - Display all documents
db.restaurants.find()

//2 - Display the restaurant_id, name, borough, and cuisine for all documents
db.restaurants.find({}, { restaurant_id: 1, name: 1, borough: 1, cuisine: 1 })

//3 - Display the restaurant_id, name, borough, and cuisine, but exclude the _id field for all documents
db.restaurants.find({}, { restaurant_id: 1, name: 1, borough: 1, cuisine: 1, _id : 0})

//4 - Display restaurant_id, name, borough, and zip code, but exclude the _id field for all documents
db.restaurants.find({}, { restaurant_id: 1, name: 1, borough: 1, 'address.zipcode': 1, _id : 0})

//5 - Show all the restaurants that are in the Bronx
db.restaurants.find({borough: 'Bronx'})

//6 - Show the first 5 restaurants that are in the Bronx
db.restaurants.find({borough: 'Bronx'}).limit(5)

//7 - Show next 5 restaurants after skipping the first 5 in the Bronx
db.restaurants.find({borough: 'Bronx'}).skip(5).limit(5)

//8 - Find the restaurants that have a score of more than 90
db.restaurants.find({"grades.score" : {$gt : 90}})

//9 - Find restaurants that have a score of more than 80 but less than 100
db.restaurants.find({"grades.score" : {$gt : 80, $not : {$gte : 100}}})

//10 - Find restaurants that are located at a latitude value less than -95.754168
db.restaurants.find({"address.coord.0" : {$lt : -95.754168}})

//11 - Find restaurants that do not serve any 'American' cuisine and have a rating greater than 70 and longitude less than -65.754168
// db.restaurants.find({cuisine : {$ne : 'American'}}) 
db.restaurants.find({cuisine: {$not : /^American/}, "grades.score" : {"$gt" : 70}, "address.coord.1" : {$lt : -65.754168}})

// SAME AS EX 11
//12 - Find the restaurants that do not prepare any 'American' cuisine and got a marker more than 70 and located in the longitude less than -65.754168. Note : Do this query without using the $and operator
db.restaurants.find({cuisine: {$not : /^American/}, "grades.score" : {"$gt" : 70}, "address.coord.1" : {$lt : -65.754168}})

//13 - Find restaurants that do not serve any 'American' cuisine and received an 'A' grade point not belonging to Brooklyn. The document should be displayed according to cuisine in descending order
db.restaurants.find({cuisine: {$not : /^American/}, "grades.grade" : "A", borough : {$ne :"Brooklyn"}})