/* Not Boring Movies 
 * 
 * X city opened a new cinema, many people would like to go to this cinema. The cinema also gives
 * out a poster indicatng the movies' ratings and descriptions. Please write a SQL query to output
 * movies with an odd numbered ID and a description that is not "boring". Order the result by rating.
 */ 
 
 Select id, movie, description, rating from cinema where id % 2 != 0 AND description != "boring" Order by rating DESC;

/* Big Countries 
 * 
 * A country is big if it has an area of bigger than 3 million square km or a population of more than 
 * 25 million. Write a SQL solution to output big countries' name, population and area. 
 */ 
 
 Select name, area, population from World Where area > 3000000 || population > 25000000;

/* Swap Salary 
 * 
 * Given a table, salary that has m=male and f=female values. Swap all f and m values with a single update
 * statement and no temp tables. Only write an update statement and no Select statement 
 */ 
 
 UPDATE salary
 SET sex = CASE
     when sex = 'f' then 'm'
     when sex = 'm' then 'f'
 END
