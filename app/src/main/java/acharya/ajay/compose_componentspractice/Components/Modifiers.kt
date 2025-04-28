package acharya.ajay.compose_componentspractice.Components

import acharya.ajay.compose_componentspractice.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/*
* Modifiers allow you to decorate or augment a composable. Modifiers let you do these sorts of things:

Change the composable's size, layout, behavior, and appearance
Add information, like accessibility labels Process user input
Add high-level interactions, like making an element clickable, scrollable, draggable, or zoomable
Modifiers are standard Kotlin objects. Create a modifier by calling one of the Modifier class functions:
*
* */

@Composable
fun ModifierSample() {
    Modi_Sample(
        name = "Jetpack Compose",
    )


}

@Composable
fun Modi_Sample(name: String) {
    Column(
        modifier = Modifier
            .
//            If you want to add padding above a text baseline such that
//            you achieve a specific distance from the top of the layout
//            to the baseline, use the paddingFromBaseline modifier:
//
            paddingFromBaseline(top = 50.dp)

//             Offset
//              To position a layout relative to its original position,
        // add the offset modifier and set the offset in the x and y axis.
        // Offsets can be positive as well as non-positive.
        // The difference between padding and offset is that adding an
        // offset to a composable does not change its measurements:
        .offset(x = 20.dp, y = 10.dp)

            /*
        Order of modifiers matters
        The order of modifier functions is significant.
        Since each function makes changes to the Modifierreturned by the previous function,
        the sequence affects the final result. Let's see an example of this:
        * In the code above the whole area is clickable,
        * including the surrounding padding, because the
        * padding modifier has been applied after the clickable modifier.
        *  If the modifiers order is reversed,
        * the space added by padding does not react to user input:
        * */.padding(24.dp)
            .clickable(onClick = { /*TODO*/ })
            .fillMaxWidth()
    ) {
        Text(text = " Hello")
        Text(text = name)

        Spacer(modifier = Modifier.padding(10.dp))
//        Image
        Card(modifier = Modifier.requiredSize(width = 250.dp, height = 150.dp)) {
            Image(
                painter = painterResource(id = R.drawable.sample),
                contentDescription = "Profile Picture",
            )
        }

    }

}

@Composable
fun MatchParent(){
    Column(
        modifier = Modifier
            .padding(8.dp)
//            .fillMaxSize()

    ) {
        Text(text = "Hello")
        Text(text = "Ajay Acharya")
        Spacer(modifier = Modifier.padding(10.dp))
//        Image(
//            painter = painterResource(id = R.drawable.neonsunsetpink),
//            contentDescription = "Profile Picture",
//            modifier = Modifier
//
//                .background(Color.LightGray)
//        )
    }
}

@Composable
fun MatchParentSizeComposable(){
    Box{
        Spacer(
            modifier = Modifier
                .matchParentSize()
                .background(Color.LightGray)
        )
        MatchParent()
    }
}


//Wieght in Row and Column

@Composable
fun WieghtComposable(){

    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ){
        Image(modifier = Modifier.weight(2f)
            .size(90.dp),
            painter = painterResource(id = R.drawable.profilepic),
            contentDescription = "Profile Picture")

        Column(
            modifier = Modifier.weight(1f)
        ){
            Text(text = "Hello")
            Text(text = "Ajay Acharya")

        }

    }
}
@Composable
@Preview(showBackground = true)
fun WeightComposablePreview() {
    WieghtComposable()
}

@Composable
@Preview(showBackground = true, showSystemUi = false)
fun ModifiersPreview() {
    ModifierSample()
}

@Composable
@Preview(showBackground = true)
fun MatchParentSizePreview() {
    MatchParentSizeComposable()
}