KDTree
======

Java implementation of an n-dimensional KD-tree.

This was my final project for CS 1332 - Data Structures and Algorithms at Georgia Tech. The assignment was to pick a suffienciently difficult data structure (i.e. not a linked list or standard binary tree) and implement it.

The KD tree is a space partitioning tree that is particularly suited for running nearest-neighbors search on large datasets. 

The set of n-dimensional points is the root. The root is divided first into two n-dimensional hyper-rectangles along the 1st dimension, and those hyper-rectangles become the top level children in the tree. 

Those hyper-rectangles are each divided along the next dimension, so each child has two children, and so on and so forth down the tree, cycling through dimensions, until the leaf nodes contain <= x points, usually 10 or so although this is very dataset dependent.

The magic of the KD tree for nearest neighbors is that it allows pruning on a large scale. While doing nearest neighbors, naturally I have a candidate nearest neighbor point that I'm holding onto while recursing through the tree. 

In brute force nearest neighbors, I have a query node and I simply cycle through every node in the dataset to compute the distance between it and my query point. This is obviously an O(n) operation.

When I encounter a new node, I can compute the distance from my query node to the boundary of the hyper-rectangle of the new node. If that distance is greater than the distance of my candidate nearest neighbor, I don't have to look at any actual points in that node or any of its children: I just prune it and move on. This means that I can skip computations for huge amounts of points in the dataset. Nearest-Neighbors search with a KD-Tree is O(log(n)), as seen here: http://en.wikipedia.org/wiki/K-d_tree#Nearest_neighbour_search

Typically, KD-Trees are used to do analysis on large, existing datasets. The structure is not dynamic, as adding or removing points would require a rebalancing so complex that it amounts to creating a new tree.
