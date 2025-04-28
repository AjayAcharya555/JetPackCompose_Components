package acharya.ajay.compose_componentspractice.Components

import acharya.ajay.compose_componentspractice.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LayoutBasics() {

    ArtistCard(
        onClick = { })

}

@Composable
fun ArtistCard(onClick: () -> Unit) {

    /*
    * To set children's position within a Row, set the horizontalArrangement
    * and verticalAlignment arguments. * For a Column, set the verticalArrangement
    * and horizontalAlignment arguments:*/

    Row(
        modifier = Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.profilepic),
                contentDescription = "Profile Picture",
                modifier = Modifier.size(50.dp),


                )
            Icon(
                Icons.Filled.CheckCircle, contentDescription = "Online Status",
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .size(20.dp),
            )
        }
        Column(modifier = Modifier.padding(8.dp)) {
            Text("AjayAcharya")
            Text("3 minutes ago")
        }

    }

    Column(
        modifier = Modifier
//          In the code above the whole area is clickable,
            //          including the surrounding padding, because the padding modifier has been
            //          applied after the clickable modifier. If the modifiers order is reversed,
            //          the space added by padding does not react to user input:
            .padding(8.dp)
            .clickable { onClick() }

    ) {

        Spacer(modifier = Modifier.padding(30.dp))


        Card(elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)) {
            Image(
                painter = painterResource(id = R.drawable.neonsunsetpink),
                contentDescription = "Profile Picture"
            )
        }
    }

}

@Composable
@Preview(showBackground = true)
fun LayoutBasicsPreview() {
    LayoutBasics()
}