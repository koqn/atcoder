#!/usr/local/bin/perl

my $i = 1;
print "100000 50000\n";
for (1..50000) {
  print $i++." ".$i++." 1\n";
}
