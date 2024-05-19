	Basic idea: approximate OTP using a key stream generator which generates
	an arbitrary length keystream from a short, fixed-length key.
	• The generation of the keystream must be reproducible (deterministic) — a
	finite state machine.
	• Therefore, the sequence must necessarily be cyclic. The period is the length
	of the sequence before it repeats.

![[Pasted image 20240519224045.png]]
