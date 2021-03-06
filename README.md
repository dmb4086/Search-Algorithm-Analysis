# Search-Algorithm-Analysis
to study the behavior of search algorithms across various sets of inputs using a technique called Monte Carlo analysis

## What is Monte Carlo Algorithm 

Monte Carlo analysis involves subjecting a system to random input perturbations in order to see how it responds 
across a wide variety of inputs. For this Repository my purpose is to focus on studying how the average number of operations of three 
search algorithms varies across a collection of randomly generated data sets.Specifically, I will be analyzing 
linear search, binary search, and interpolation search in terms of the average number of operation search algorithm 
performs on average over a series of data sets.

### Data Sets 

> For this analysis I used a fairly large Dataset 
> I used a 2 dimensional array (an array of arrays )

I generated 100 data sets of 1,000 elements each with random values ranging from 1 to 10,000, which I used to evaluate linearsearch, binary search, and interpolation search. For each data set, I executed a search using each algorithm to find every 
element contained in that data set. After a search for a single element using a given algorithm, I recorded the number of operations that the algorithm performed to find that element. Once I searched for all elements with each algorithm, I computed the average number of operations that each algorithm performed 
across all of the searches for that data set. Similarly, for each data set, I executed a search for 1,000 random values between 1 and 10,000 that are **not** contained in the data set. The Table below shows you my recorded observations


|                      	| Successful Searches 	| Unsuccessful Searches 	| Theoretical 	|  
|----------------------	|---------------------	|-----------------------	|-------------	|
| Linear Search         | 500.4495400000002   	| 29.43                 	| Yes           |  
| Binary Search        	| 8.88934             	| 9.5                   	| Yes           |   
| Interpolation Search 	| 3.2270999999999996  	| 1.29                  	| Yes           |  


## Conclusion 

We can clearly see form the table above that from large theoretical dataset provided Interpolation Search was able to search for the key in the least average time.

Linear Search was the slowest of the three but but Linear Search isn't inherently bad and binary searches isn't always better.

If you have a use case where you often need to add elements to your array, keeping your array sorted can be very expensive. Sorting algorithms are usually O(n*log n) complexity and that may be slower than performing a simple linear search on your array.

