# CoordinatePlot

Found one issue when rotating the device, the Y slider isn't visible.

# Polishing findings

When rotating the device sliders weren't keeping the state, was updated to rememberSaveable in order to keep the sliders thumb in their updated value as well as the image.

When the device is in landscape mode Yslider wasn't visible, was added verticalScroll to column to make it scrollable and then second slider was visible. 

Was discovered that we can add modifier .width(16.dp) instead of .size(width:height:), so it was updated.

Updated handling for landscape mode, rearranged the UI to see the sliders. 
