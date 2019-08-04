# F1 Fee Distribution

This is toy implementation of an interesting solution to the problem of rewards distribution in an on-chain resource pool (mining pool, staking pool, DAO, etc.). 

A mirror of the original proposal is avaiable [here](/Ojha19.pdf).  

## How do I play with this? 

If you are familiar with Java, just import the project (using the provided Gradle model) into your favourite IDE. 

Otherwise, the fastest way to get started is to download IntelliJ IDEA (community) and import the project:
* `File > New > Project From Existing Sources ...`
* Select the root of this project directory 
* Select "Import project from external model" radio button and select "Gradle" from the list
* Accept the defaults and press `Finish`  

### Running the Tests 

A very rudimentary test is provided to demontrate the use of F1 rewards manager. The test lives in: 
`/src/test/java/org/aion/f1/FuzzingTest.java`

The test randomly generates a transcript of events (vote, unvote, withdraw, block produced) in a simple proof of stake system, where block rewards are distributed to delegators (voters), according to the ratio of their staked coins to the total coins delegated in the staking system. Block production is simulated with a `BLOCK` event (i.e. the block boundary, where some block rewards are distributed). The output of the F1 rewards manager is compared with the naive implmentation of a rewards distribution algorithm, which runs at some hypothetical `onBlockProduced` event (consider a "coinbase transaction" which runs the rewards distribution logic to disburse stakers the block rewards). 

The test is called `testVectorAutogen()` and is a JUnit test; it can be run using your IDE's JUnit test runner or using `gradle test` on the command line. 
