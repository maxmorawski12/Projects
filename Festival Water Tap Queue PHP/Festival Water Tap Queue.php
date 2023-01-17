<?php

	function fillup(array $waterbottles, $taps, $fixednumb){
	$timetaken = [];
	
	// Lines 14 and 15 select taps and flow rate for first values (taps 1, 3 ,5 etc, 200ml flowrate)
	foreach ($waterbottles as $time) {
		if (sizeof($timetaken) < $taps) {
			if (sizeof($timetaken) % 2 == 0) {
				$time = $time/200;
				array_push($timetaken,$time);
		}
		else{
			// For all other taps 100ml flow rate
			$time = $time/100;
			array_push($timetaken,$time);
		}		
		}

	}
	$amountoftaps = $taps;
		// Input remainder of values from array according to first tap available and adds fixed time to walk to tap 
		// Stop when all values from array have been input
		// Minus amount of taps as they have been already input in previous loop
	for($i = 0; $i < sizeof($waterbottles) - $amountoftaps; $i++){		
		// Assign Index to the lowest value in the array
		$index = array_search(min($timetaken), $timetaken);
		
		// Every Odd Numbered Tap will have a different flow rate
		if ($index % 2 == 0){
		// Increasing the 200 Flow Rate between 201 - 208 increases the time (Change line 16 to match flow rate in line 41)
		// Due to the fact that the person in the queue will use a different tap
		// Example - 200, 300, 400 , 500, 500, 600, 4000, 500, 300, 500, 850, 900, 1250, 350, 450
		// Using 3 Taps and 2 seconds fixed time
		$newnumber = $timetaken[$index] + $waterbottles[$taps++]/200 + $fixednumb;
		$timetaken[$index] = $newnumber;

			}
		// If the tap is not odd, flow rate is fixed to 100
			else{
				$newnumber = $timetaken[$index] + $waterbottles[$taps++]/100 + $fixednumb;
				$timetaken[$index] = $newnumber;	
			}			
		}
	
	// Print maximum amount of time
	$totaltime = max($timetaken);
	$maxindex = array_search(max($timetaken), $timetaken);
	echo "Tap ";
	// Due to array starting at 0 for first value + 1 to display correct tap
	echo $maxindex+1; 
	echo " will take the longest at ";
	echo $totaltime;
	echo " seconds <br>";
	// Display array showing all values
	print_r($timetaken);
		


}
?>	
<!DOCTYPE html>
<html>
<head>
<title>Festival Water Queue</title>
</head>
<body>
<!-- User Input -->
<form action="CodeTaskBonusesUpdated.php" method="POST">
	<input type="text" name="waterbottles" placeholder="Enter water bottles as array">
	<input type="text" name="taps" placeholder="Enter in amount of taps">
	<input type="text" name="fixed" placeholder="Enter time taken to walk to tap" size="25">
	<button type="submit" name="submit">Submit</button>
	
</form>
<?php
	// Runs when Submit button is pressed on form
	if(isset($_POST['submit'])){
		$taps = $_POST['taps'];
		$fixednumb = $_POST['fixed'];

	try{
	// If user input is wrong across any of the 3 input throws an exception
		if (!preg_match('/^[0-9, ]+$/', $_POST['waterbottles']) or !preg_match('/^[0-9]+$/', $_POST['taps']) or !preg_match('/^[0-9.]+$/', $_POST['fixed']) or $_POST['taps'] == 0){
			throw new Exception();
    	}

    // Correctly Formats the Array for Function to work properly
    $waterbottles = preg_split ("/\,/", $_POST['waterbottles']);

	// Runs function
	fillup($waterbottles, $taps, $fixednumb);
	 
	// Error message from thrown Exception
}catch(Exception){
    	echo "Wrong Input,<br> 
    		  Please Enter Water Bottles sizes in this form - 200, 300, 400 etc.<br> 
    		  Please Enter the amount of taps as an Integer. <br>
    		  Please Enter the amount of time it takes to walk to the tap";
	
}
}

?>
</body>
</html>



    





 




