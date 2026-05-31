# OtherProjects - Lab 03 (String/StringBuilder/StringBuffer exercises)

## Package structure
- hust.soict.dsai.garbage
  - ConcatenationInLoops.java  -- compares +, StringBuilder, StringBuffer speed
  - GarbageCreator.java        -- shows memory issues with String + in loops
  - NoGarbage.java             -- efficient alternative using StringBuilder

## How to compile & run (from OtherProjects/ directory)
```bash
javac -d bin -sourcepath src src/hust/soict/dsai/garbage/*.java
java -cp bin hust.soict.dsai.garbage.ConcatenationInLoops
java -cp bin hust.soict.dsai.garbage.NoGarbage
java -cp bin hust.soict.dsai.garbage.GarbageCreator
```
