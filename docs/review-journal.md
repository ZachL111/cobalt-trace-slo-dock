# Review Journal

The cases below are the review handles I would use before changing the implementation.

The local checks classify each case as `ship`, `watch`, or `hold`. That gives the project a small review vocabulary that matches its observability focus without claiming live deployment or external usage.

## Cases

- `baseline`: `span volume`, score 130, lane `watch`
- `stress`: `latency skew`, score 163, lane `ship`
- `edge`: `signal loss`, score 169, lane `ship`
- `recovery`: `incident shape`, score 183, lane `ship`
- `stale`: `span volume`, score 194, lane `ship`

## Note

A future change should add new cases before it changes the scoring rule.
