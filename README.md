# cobalt-trace-slo-dock

`cobalt-trace-slo-dock` is a focused Scala codebase around package a Scala local lab for slo analysis with bounded scenario files, conflict explanations, and documented operating limits. It is meant to be easy to inspect, run, and extend without a hosted service.

## Cobalt Trace Slo Dock Walkthrough

I would read the project from the outside in: command, fixture, model, then roadmap. That keeps the observability idea grounded in files that can be checked locally.

## Reason For The Project

The repository exists to keep a technical idea small enough to reason about. The implementation avoids external dependencies where possible, then uses fixtures to make changes easy to review.

## How It Is Put Together

The core is a scoring model over demand, capacity, latency, risk, and weight. That keeps span data, log shape, and latency summaries in one explicit decision path. The threshold is 170, with risk penalty 7, latency penalty 2, and weight bonus 6. The Scala code uses case classes and a compact object API to keep the test path direct.

## Data Notes

`pressure` is the first example I would inspect because it lands on the `review` path with a score of 95. The broader file also keeps `degraded` at -8 and `surge` at 224, which gives the model a useful low-to-high spread.

## Capabilities

- Uses fixture data to keep log shape changes visible in code review.
- Includes extended examples for latency summaries, including `surge` and `degraded`.
- Documents incident slices tradeoffs in `docs/operations.md`.
- Runs locally with a single verification command and no external credentials.
- Stores project constants and verification metadata in `metadata/project.json`.

## Getting It Running

Install Scala and run the commands from the repository root. The project does not need credentials or a hosted service.

## Check The Work

```powershell
powershell -NoProfile -ExecutionPolicy Bypass -File scripts/audit.ps1
```

The audit command checks repository structure and README constraints before it delegates to the verifier.

## Where Things Live

- `src`: primary implementation
- `tests`: verification harness
- `fixtures`: compact golden scenarios
- `examples`: expanded scenario set
- `metadata`: project constants and verification metadata
- `docs`: operations and extension notes
- `scripts`: local verification and audit commands

## Tradeoffs

The scoring model is simple by design. More domain-specific behavior should be added through explicit adapters or extra fixture classes rather than hidden constants.

## Possible Extensions

- Add a short report command that prints the score breakdown for a single scenario.
- Add malformed input fixtures so the failure path is as visible as the happy path.
- Split the scoring constants into a typed configuration object and validate it before use.
- Add one more observability fixture that focuses on a malformed or borderline input.

## Command Examples

```powershell
powershell -NoProfile -ExecutionPolicy Bypass -File scripts/verify.ps1
```

This runs the language-level build or test path against the compact fixture set.
