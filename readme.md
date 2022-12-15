I am mostly a python guy, so naturally I just didn't like java arrays. Sue me.

Aims to follow concepts somewhat similar to functional programming (although I know close to nothing about it) while implementing python-like methods of working with arrays.

`class Sequence`

### Class variables
`int[] sequence`, `int length`

### Constructors
* `Sequence()`
  Will create an empty sequence.
* `Sequence(int sequence_length, boolean initialise_random)`
  Will create an empty sequence of length `sequence_length`. If `intialise_random` is set to `true`, the values will be initialised to integers in range [$0, 10 \times$`sequence_length`].
* `Sequence(Sequence seq)`
  Will create a new copy of given sequence object. I don't know why you want to do this.
* `Sequence(int[] arr)`
  Will create a Sequence object from the given integer array `arr`.

### Methods
* `int at(int i)`, `int index(int i)`
  Will return the element at index `i`.
* `Sequence append(int e)`
  Append a new integer `e` to the sequence. Returns current instance.
* `Sequence append(Sequence seq)`, `Sequence append(int[] arr)`
  Concatenates another sequence object or integer array to the current instance. Returns current instance.  
   `join(int[] arr)` may be renamed in the future because this is confusing. 
* `Sequence joined(Sequence seq)`, `Sequence joined(int[] arr)`
  Same functionality as `append(Sequence seq)` or `append(int[] arr)`, but returns a new object instead of concatenating inplace.
* `Sequence swap(int i, int j)`
  Swap elements at indices `i` and `j`. Returns current instance.
* `Sequence swapped(int i, int j)`
  Creates a Sequence object with elements at indices `i` and `j` swapped. Returns the object.
* `Sequence subSequence(int i, int j)`, `Sequence index(int i, int j)`
  Creates a sequence object that is a subsequence of the original from position `i` to `j-1`. Python-style. Returns the object.
* `void toString()`, `void println()`, `void print()`:
  Does what you expect.

### Examples

#### `swapped()`
**Input**
```Java
int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
Sequence sequence = new Sequence(arr);

sequence.println();
sequence.swapped(3, 5)
        .println();
```
**Output**
```
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
[0, 1, 2, 5, 4, 3, 6, 7, 8, 9]
```

#### `append()`
**Input**
```Java
sequence.println();
arr = {10, 11, 12};
sequence.append(arr)
        .println();
```
**Output**
```
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
[0, 1, 2, 5, 4, 3, 6, 7, 8, 9, 10, 11, 12]
```


#### Functional-like Usage
**Input**
```Java
int[] a1 = {2, 5, 7, 3, 9};
Sequence s1 = new Sequence(a1);
s1.println();
int[] a2 = {1, 6, 4, 8, 0};
Sequence s2 = new Sequence(a2);
s2.println();

s1.joined(s2)
  .swap(5, 6)
  .index(3, 8)
  .println();
```
**Output**
```
[2, 5, 7, 3, 9]
[1, 6, 4, 8, 0]
[3, 9, 6, 1, 4]
```

