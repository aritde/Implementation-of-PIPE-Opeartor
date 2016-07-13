# Implementation-of-PIPE-Opeartor

This program implements the PIPE(|) functionality used in LINUX Environments using the Chain of Responsibility Design Pattern. 
Eg : Add 2 3 | Subtract 4 | Multiply 5 outputs 5

The commands take either one or two parameters depending on the position of the operation. Ideally, the first operation should have 2 operands. The result of this operation is used in the next operation along with the explicit operand provided for the second operation and so on.
