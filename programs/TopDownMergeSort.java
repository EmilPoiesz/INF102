public class TopDownMergeSort {
  
public  static void mergesort(Comparable[] a, int lo, int hi) {
  if (hi==lo) return;
  int mid = lo + (hi-lo)/2;
  mergesort(a,lo,mid); // left half
  mergesort(a,mid+1,hi); // right half
  merge(a,lo,mid+1,hi);
}

public static void merge(Comparable[] a,  int lo, int m, int hi) {
  Comparable[] aux = new Comparable[a.length]; // in general too long
  for (int k=lo; k<=hi; k++) aux[k] = a[k];
  int l = lo, r = m;
  for (int k=lo; k<=hi; k++){ // assert (l+r-k == m);
   if (l==m) {a[k] = aux[r++]; continue;}
   if (r==hi+1) {a[k] = aux[l++]; continue;}
   if (less(aux[l],aux[r])) {a[k] = aux[l++];} else {a[k] = aux[r++];} // max N compares
  } 
}

public  static void sort(Comparable[] a) { mergesort(a,0,a.length-1);}  

private static boolean less(Comparable v, Comparable w){
  return v.compareTo(w) < 0; }

private static void exch(Comparable[] a, int i, int j){
  Comparable t = a[i]; a[i] = a[j]; a[j] = t; }

private static void show(Comparable[] a){
  for (Comparable o : a) StdOut.print(o+" "); StdOut.println();}

public static boolean isSorted(Comparable[] a){
  for (int i=1; i<a.length; i++) if (less(a[i],a[i-1])) return false;
  return true;}

public static void main(String[] args){
  String[] a = In.readStrings();
  sort(a); assert isSorted(a); show(a);
}//End of main
}//End of TopDownMergeSort based on Algorithms, 4th Edition, p. 2xx

