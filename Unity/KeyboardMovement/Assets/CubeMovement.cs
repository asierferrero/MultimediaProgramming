using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CubeMovement : MonoBehaviour
{
    public float speed = 5f;
    private float horizontalMovement = 0f;
    private float verticalMovement = 0f;

    // Update is called once per frame
    void Update()
    {
        horizontalMovement = 0;
        verticalMovement = 0;

        if (Input.GetKey(KeyCode.W))
        {
            verticalMovement = 1f;
        }

        if (Input.GetKey(KeyCode.S))
        {
            verticalMovement = -1f;
        }

        if (Input.GetKey(KeyCode.A))
        {
            horizontalMovement = -1f;
        }

        if (Input.GetKey(KeyCode.D))
        {
            horizontalMovement = 1f;
        }

        // Calculate the vector movement based on the variables
        Vector3 movement = new Vector3(horizontalMovement, 0f, verticalMovement) * speed * Time.deltaTime;

        // Apply the cube movement to X and Z
        transform.Translate(movement);
    }
}
