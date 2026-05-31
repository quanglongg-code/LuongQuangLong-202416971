# AimsProject - Lab 03: Basic OO Techniques

## Package Structure

```
AimsProject/
├── answers.txt                                   ← Answers to all lab questions
├── src/
│   └── hust/soict/dsai/
│       ├── aims/
│       │   ├── Aims.java                         ← Main entry point
│       │   ├── cart/Cart.java                    ← Cart with overloaded add methods, print, search
│       │   ├── disc/DigitalVideoDisc.java         ← DVD with static id counter, toString, isMatch
│       │   └── store/Store.java                  ← Store with addDVD / removeDVD
│       └── test/
│           ├── cart/CartTest.java                ← Tests all Cart methods
│           ├── disc/TestPassingParameter.java     ← Demonstrates Java pass-by-value
│           └── store/StoreTest.java              ← Tests Store methods
```

## Key Concepts Implemented

| Section | Feature |
|---------|---------|
| 1       | Git Release Flow branching strategy |
| 2.1     | Method overloading by type: `addDigitalVideoDisc(DigitalVideoDisc[])`, varargs |
| 2.2     | Method overloading by count: `addDigitalVideoDisc(dvd1, dvd2)` |
| 3       | Java is pass-by-value; correct swap via wrapper array |
| 4       | Eclipse debug instructions (see lab PDF) |
| 5       | `nbDigitalVideoDiscs` (static/classifier) + `id` (instance) in DigitalVideoDisc |
| 6       | `Cart.print()`, `searchById()`, `searchByTitle()` + `isMatch()` |
| 7       | `Store` class with `addDVD()` / `removeDVD()` |
| 8       | Package re-organisation (hust.soict.dsai.*) |
| 9       | See OtherProjects: String vs StringBuilder vs StringBuffer |

## How to Compile & Run (from AimsProject/ directory)

```bash
# Compile all
javac -d bin -sourcepath src $(find src -name "*.java")

# Run CartTest
java -cp bin hust.soict.dsai.test.cart.CartTest

# Run StoreTest
java -cp bin hust.soict.dsai.test.store.StoreTest

# Run TestPassingParameter
java -cp bin hust.soict.dsai.test.disc.TestPassingParameter

# Run Aims (main)
java -cp bin hust.soict.dsai.aims.Aims
```

## Git Branch Plan (Release Flow)

| Branch | Purpose |
|--------|---------|
| `refactor/apply-release-flow` | Reorganise repo to follow Release Flow |
| `topic/method-overloading` | Section 2: method overloading |
| `topic/passing-parameter` | Section 3: pass-by-value investigation |
| `topic/class-members` | Section 5: static vs instance members |
| `feature/print-cart` | Section 6: print cart |
| `feature/search-cart` | Section 6: search cart |
| `topic/store` | Section 7: Store class |
| `refactor/packages` | Section 8: package reorganisation |
| `topic/memory-management-string` | Section 9: String/StringBuffer/StringBuilder |
| `release/lab03` | **Final submission branch** |
