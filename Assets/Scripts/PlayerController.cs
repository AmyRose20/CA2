using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerController : MonoBehaviour
{
    // Variable will be used to control the player's speed
    public float moveSpeed;

    // Use this for initialization
    void Start()
    {

    }

    // Update is called once per frame
    void Update()
    {
        /* 'Input' is a built in class. We can access it's functions using the syntax
         Input.function. 'GetAxisRaw' will return the axis value acccording to the
         axis-name or string inputted. In this case, it is "Horizontal". 
         The if statements states, that if the x-axis is greater than 0.5 or less than 
         -0.5 to excecute. */
        if (Input.GetAxisRaw("Horizontal") > 0.5f || Input.GetAxisRaw("Horizontal") < -0.5f)
        {
            // 'Translate' will move the player a certain amount within the world.
            /* A new 'Vector3' object instance is created. This object is essentially
             thee x, y and z-axis combined into one value ie, the position of the player.
             Variable values such as the horizontal x-axis value multiplied by 'moveSpeed'
             and 'Time.delta' (the amount of time between each frame) will be passed 
             as parameters to the 'Vector3' class. As we only want to move the player 
             on the x-axis, The values for the y-axis and z-axis are 0. */
            transform.Translate(new Vector3(Input.GetAxisRaw("Horizontal") * moveSpeed * Time.deltaTime, 0f, 0f));
        }
        if (Input.GetAxisRaw("Vertical") > 0.5f || Input.GetAxisRaw("Vertical") < -0.5f)
        {
            /* This time, the value being passed is focused on the y-axis position of the player.
             Again, the value is received by using 'GetAxisRaw' within the 'Input' class. As we
             are only focusing on the y-axis, the values passed for x-axis and z-axis are zero. */
            transform.Translate(new Vector3(0f, Input.GetAxisRaw("Vertical") * moveSpeed * Time.deltaTime, 0f));
        }
    }
}

