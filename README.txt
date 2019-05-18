-- Group Members(github ID): Will Wang(wsl100624), Coco Zhu(zhusyx), Pengxue Her(Soujirou152).

-- Test Coverage of non-UI code: 95% in overall 

-- UML (Before): 

-- UML (After):

-- Refactoring:
     1. Low coupling
            Made KittyPot separated from Round class
            Made KittyPot as a static class and used by all the classes easily
     2. High Cohesion
            Made indivdual class for all the Constants
     3. Extract methods
            showTurnSummary
            skunkPenalty
