# cobalt-trace-slo-dock

`cobalt-trace-slo-dock` is a compact Scala repository for observability, centered on this goal: Package a Scala local lab for slo analysis with bounded scenario files, conflict explanations, and documented operating limits.

## Why It Exists

The project exists to keep a narrow engineering decision visible and testable. For this repo, that decision is how span volume and signal loss should influence a review result.

## Cobalt Trace Slo Dock Review Notes

`stale` and `baseline` are the cases worth reading first. They show the optimistic and cautious ends of the fixture.

## Features

- `fixtures/domain_review.csv` adds cases for span volume and latency skew.
- `metadata/domain-review.json` records the same cases in structured form.
- `config/review-profile.json` captures the read order and the two review questions.
- `examples/cobalt-trace-slo-walkthrough.md` walks through the case spread.
- The Scala code includes a review path for `span volume` and `span volume`.
- `docs/field-notes.md` explains the strongest and weakest cases.

## Architecture Notes

The implementation keeps the scoring rule plain: reward signal and confidence, preserve slack, penalize drag, then classify the result into a review lane.

The Scala implementation avoids hidden state so fixture changes are easy to reason about.

## Usage

```powershell
powershell -NoProfile -ExecutionPolicy Bypass -File scripts/verify.ps1
```

## Tests

The same command runs the local verification path. The highest-scoring domain case is `stale` at 194, which lands in `ship`. The most cautious case is `baseline` at 130, which lands in `watch`.

## Limitations And Roadmap

No external service is required. A deeper version would add more negative cases and a clearer boundary around invalid input.
