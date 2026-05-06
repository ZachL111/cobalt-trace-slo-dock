# Cobalt Trace Slo Dock Walkthrough

This note is the quickest way to read the extra review model in `cobalt-trace-slo-dock`.

| Case | Focus | Score | Lane |
| --- | --- | ---: | --- |
| baseline | span volume | 130 | watch |
| stress | latency skew | 163 | ship |
| edge | signal loss | 169 | ship |
| recovery | incident shape | 183 | ship |
| stale | span volume | 194 | ship |

Start with `stale` and `baseline`. They create the widest contrast in this repository's fixture set, which makes them better review anchors than the middle cases.

The next useful expansion would be a malformed fixture around latency skew and incident shape.
