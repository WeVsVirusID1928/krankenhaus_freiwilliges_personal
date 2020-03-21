# Generate help documentation from Makefile comments
#  See the form of comments in the said Makefile.

BEGIN {
    n = 0
}

/^# make / {
    gsub("^# make ", "")
    target[n] = $0
    read_short_documentation = 1
    next
}

read_short_documentation {
    gsub("^#  *", "")
    documentation[target[n]] = $0
    read_short_documentation = 0
    ++ n
}

END {
    for(i = 0; i < n; ++i) {
	printf("  %-27s - %s\n", "make " target[i], documentation[target[i]])
    }
}
