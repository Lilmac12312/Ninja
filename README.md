=== Ninja - The hack regulator that only regulates. ===

= "Ninja" is a new approach to hack prevention and detection on Minecraft servers.  Hacks are constantly evolving with workarounds for hack preventions. =

Well, we're going to end that.  "How?", you might ask.  Simple: Don't block, just regulate.  
Attempting to write specific code just to block certain things in hacked clients is useless.  Instead, why not just regulate things and find out what is real and what is not?

= Current Planned Check Setup: =

--> Player fails check
--> Calls the CheckFailedEvent
--> The listener on this event will determine whether the hack is legitimate.  If it is not, we will simple cancel the action
--> Result is recorded for data comparison in future hackers & non-hackers.

==========

Simple enough, right?

= TODO =
* Explain this better, and I need to figure out if I want to have the bukkit event system or just call one event when they fail a check.
* Decide on alert system setup
* Set up player objects, caching, and check data.
